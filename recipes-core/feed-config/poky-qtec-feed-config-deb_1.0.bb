CRIPTION = "Poky Qtec feed configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PE = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI += "file://yocto-qtec.gpg"

RDEPENDS_${PN} += "gnupg"

do_compile_qt5022-fglrx() {
	rm -f qt5022-cesium.list

	for arch in qt5022_fglrx bobcat_64 all; do
		echo "deb http://release.qtec.com:5022/core/cesium/qt5022-fglrx/deb/${arch} ./" >> qt5022-cesium.list
	done
}

do_compile_qt5022-open() {
	rm -f qt5022-cesium.list

	for arch in qt5022_open bobcat_64 all; do
		echo "deb http://release.qtec.com:5022/core/cesium/qt5022-open/deb/${arch} ./" >> qt5022-cesium.list
	done
}

do_install () {
	install -d ${D}${sysconfdir}/apt/sources.list.d/
	install -m 0644  ${S}/qt5022-cesium.list ${D}${sysconfdir}/apt/sources.list.d/
	install -d ${D}${sysconfdir}/apt/trusted.gpg.d/
	install -m 0644  ${WORKDIR}/yocto-qtec.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/
}

FILES_${PN} = "${sysconfdir}/apt/ "

CONFFILES_${PN} += "${sysconfdir}/apt/sources.list.d/qt5022-cesium.list"

