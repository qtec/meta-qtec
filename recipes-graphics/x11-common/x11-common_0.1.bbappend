FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

RDEPENDS_${PN} += "pciutils"

SRC_URI +="file://Xserver"

do_install_append(){
	install -m 755 Xserver ${D}${sysconfdir}/X11/
}

