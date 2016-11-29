SUMMARY = "GStreamer GObject Introspection overrides for Python"
HOMEPAGE = "https://gstreamer.freedesktop.org"
SECTION = "multimedia"
DEPENDS = "gstreamer1.0 python3-pygobject python3 python3-native"
RDEPENDS_${PN} += "python3-pygobject python3 python3-codecs"

SRC_URI = " \
	git://anongit.freedesktop.org/gstreamer/gst-python;name=base;branch=1.10 \
	git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
	file://pythonpath.patch \
	"

SRCREV_base = "158131020044ecd5ccd4d0b74024016ed6c807dc"
SRCREV_common = "d7ecca16114e443dab9d6f8cbc47a1554e3d4b30"
SRCREV_FORMAT = "base"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c34deae4e395ca07e725ab0076a5f740"
FILES_${PN} += "${libdir}"

inherit autotools pkgconfig

S = "${WORKDIR}/git"

EXTRA_OECONF = "--with-pygi-overrides-dir=/usr/lib/python3.5/site-packages/gi/overrides"

PE =  "1"
PV = "1.10.0+git${SRCPV}"
