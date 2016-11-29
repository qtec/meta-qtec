DEPENDS += "libopus"

SRC_URI = "git://github.com/qtec/gst-plugins-base.git;branch=qtec;name=base"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common"
SRCREV_base = "1ba9a96fde7ca729e3f659c854446df51658a6dd"
SRCREV_common = "f980fd91c1c1fd01333966041a4a535366e897bd"
SRCREV_FORMAT = "base"

PACKAGECONFIG += "x11 alsa orc ivorbis ogg theora vorbis pango"
PV = "1.10.0+git${SRCPV}"
