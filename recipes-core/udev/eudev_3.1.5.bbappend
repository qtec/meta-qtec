SRC_URI += "file://99-qtec-video.rules"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
RDEPENDS_${PN} += "util-linux-blkid"

do_install_append () {
	install -m 0644 ${WORKDIR}/99-qtec-video.rules ${D}${sysconfdir}/udev/rules.d/
}
