SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-ugly;branch=1.10;name=base"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common"
SRCREV_base = "edff3f82a0a58b7ca2ed9c785a0071478b9fe5b0"
SRCREV_common = "f980fd91c1c1fd01333966041a4a535366e897bd"
SRCREV_FORMAT = "base"

FILES_${PN} += "/usr/share/gstreamer-1.0/presets"
PACKAGECONFIG += "x264"
PV = "1.10.0+git${SRCPV}"
