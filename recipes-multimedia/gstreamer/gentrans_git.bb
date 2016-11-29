SUMMARY = "Collection of plug-ins and tools for the GStreamer multimedia framework specifically geared towards transcoding and recording purposes"
HOMEPAGE = "http://gentrans.sourceforge.net/"
SECTION = "multimedia"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base orc"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

inherit autotools pkgconfig gettext

require recipes-multimedia/gstreamer/gst-plugins-package.inc

SRC_URI = "git://git.code.sf.net/p/gentrans/code"
SRCREV = "8afe0b652ffaafcdfc105a61d59fdde31a88eca3"

PV = "1.0.3"

S = "${WORKDIR}/git"

do_configure_prepend() {
	touch ${S}/ABOUT-NLS
}

LIBV = "1.0"

PACKAGES_DYNAMIC = "^${PN}-.*"
