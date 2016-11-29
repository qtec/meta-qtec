SUMMARY = "Qtec Plugins for the GStreamer multimedia framework 1.x"
HOMEPAGE = "http://qtec.com/"
SECTION = "multimedia"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=83322fe43cb8f2bc1ea88ab553db0efe"

inherit autotools pkgconfig

RDEPENDS_gstreamer1.0-plugins-qtec-core-tests += "gstreamer1.0-plugins-base-app"

require recipes-multimedia/gstreamer/gst-plugins-package.inc

SRC_URI = "git://github.com/qtec/gst-plugins-qtec-core.git"
SRCREV = "6777f54723e6bf640ae93004e37747619df57609"

S = "${WORKDIR}/git"

LIBV = "1.0"

PACKAGES += "${BPN}-tests ${BPN}-tests-dbg"
PACKAGES_DYNAMIC = "^${PN}-.*"

FILES_${BPN}-tests-dbg =+ "/usr/share/${BPN}/.debug"
FILES_${BPN}-tests =+ "/usr/share/${BPN}/*"
FILES_${BPN}-tests-dbg =+ "/usr/share/gstreamer1.0-plugins-qtec/.debug"
FILES_${BPN}-tests =+ "/usr/share/gstreamer1.0-plugins-qtec/*"

#FIXME Remove when Makefiles are fixed!
do_compile_prepend(){
	oe_runmake clean
}

do_compile_append(){
	oe_runmake build-checks
}

PE = "1"
PV = "1.0+git${SRCPV}"
