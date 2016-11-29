DESCRIPTION = "GStreamer Validator - Detect when elements are not behaving as expected"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base cairo gtk+3 gdk-pixbuf fontconfig libpng libxext pixman pango atk libxrender orc json-glib"

require recipes-multimedia/gstreamer/gst-plugins-package.inc

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-devtools;branch=1.10;name=base"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/validate/common;name=common"
SRC_URI += "file://pkg_config_sysroot.patch"
SRC_URI += "file://nodoc.patch"
SRCREV_base = "19ddfb787ab66b87a9c1303d14d63e927d2eeeee"
SRCREV_common = "eb6a86e9e6d49f16bcbd4d02ed943005873e486a"
SRCREV_FORMAT = "base"

inherit pkgconfig autotools gettext gobject-introspection

S = "${WORKDIR}/git/validate"

do_configure_prepend(){
	touch ${S}/ABOUT-NLS
}

FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.so ${libdir}/gstreamer-1.0/*.la"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/validate/*.la"
FILES_${PN} += "${libdir}/gst-validate-launcher ${datadir}/gstreamer-1.0 ${libdir}/gstreamer-1.0/*.so.* ${libdir}/gstreamer-1.0/validate/*.so "

PV = "1.10.0+git${SRCPV}"
