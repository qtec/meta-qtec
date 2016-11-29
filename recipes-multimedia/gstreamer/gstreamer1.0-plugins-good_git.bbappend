FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/qtec/gst-plugins-good.git;branch=qtec;name=base"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common"
SRCREV_base = "07428a5fa0fdeb1a2099454321a7b263ae2543c9"
SRCREV_common = "f980fd91c1c1fd01333966041a4a535366e897bd"
SRCREV_FORMAT = "base"

PV = "1.10.0+git${SRCPV}"
