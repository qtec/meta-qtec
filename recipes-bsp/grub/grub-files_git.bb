DESCRIPTION = "Grub companion files"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=83322fe43cb8f2bc1ea88ab553db0efe"
SECTION = "qtec"
PR = "r3"

SRC_URI = "file://unicode.pf2 \
	   file://qtec.png \
	   file://LICENSE"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${libdir}/grub-files
    install -m 644 unicode.pf2 ${D}${libdir}/grub-files/
    install -m 644 qtec.png ${D}${libdir}/grub-files/
}

