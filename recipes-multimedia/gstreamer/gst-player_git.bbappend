SRCREV = "d15e5e6f5832d6966443b024c0b406201cc5d8b9"
SRC_URI = "\
		git://github.com/sdroege/gst-player.git \
		file://gstdoc.patch \
		file://gst-player.desktop \
	   "
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} = "${datadir}/applications/*.desktop"
FILES_${PN}-bin = "${bindir}/"
