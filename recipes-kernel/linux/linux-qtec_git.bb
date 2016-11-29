inherit kernel

PACKAGES += "kernel-firmware"

DESCRIPTION = "Linux kernel for Qtec platforms"
SECTION = "kernel"
LICENSE = "GPLv2"

DEPENDS += "bc-native"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PE = "1"

PV = "4.8.0"
SRC_URI = "git://github.com/qtec/linux.git;branch=v4.8-qtec"
SRCREV = "d225f1336f79a4529d87daa528c660734f1cb8d3"

S = "${WORKDIR}/git"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} O=${B} qt5022_defconfig"

python split_kernel_packages_append () {
    do_split_packages(d, root='/lib/firmware', file_regex='^(.*)\.dtb$', output_pattern='kernel-firmware-%s', description='Firmware for %s', recursive=True, extra_depends='')
    do_split_packages(d, root='/lib/firmware', file_regex='^(.*)\.kbpi$', output_pattern='kernel-firmware-%s', description='Firmware for %s', recursive=True, extra_depends='')
}

python populate_packages_prepend () {
    metapkg =  'kernel-firmware'
    bb.data.setVar('ALLOW_EMPTY_' + metapkg, "1", d)

    metapkg_rdepends = [ ]
    blacklist = [ metapkg ]
    packages = bb.data.getVar('PACKAGES', d, 1).split()
    for pkg in packages[1:]:
        if pkg.startswith('kernel-firmware-') and not pkg in blacklist and not (pkg.startswith('kernel-firmware-r') and (pkg.endswith('-cp') or pkg.endswith('-pfp') or pkg.endswith('-me'))):
            metapkg_rdepends.append(pkg)
    bb.data.setVar('RDEPENDS_' + metapkg, ' '.join(metapkg_rdepends), d)


}
