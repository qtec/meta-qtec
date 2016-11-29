DESCRIPTION = "Inspired by top and perf-top, gst-top displays performance report for the command, analyzing GStreamer ABI calls."
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"
SECTION = "multimedia"

DEPENDS += "gstreamer1.0"

EXTRA_OECONF = " --disable-ui"
SRC_URI = "git://github.com/qtec/gst-instruments.git;branch=qtec"

SRCREV = "98ea371ba6757eb4302c152b68bcdd3a93d4f0cb"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
