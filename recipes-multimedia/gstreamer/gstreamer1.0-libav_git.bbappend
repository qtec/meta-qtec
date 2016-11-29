SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-libav;branch=1.10;name=base;branch=1.10"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common"
SRC_URI += "git://source.ffmpeg.org/ffmpeg.git;destsuffix=git/gst-libs/ext/libav;name=libav;nobranch=1"

SRCREV_base = "53e5dd77f7b0f06dabe2cc3cef49c3f848b2780a"
SRCREV_common = "f980fd91c1c1fd01333966041a4a535366e897bd"
SRCREV_libav = "ebf8ec5b0fdc0b79602312feecbe9f1797e90033"
SRCREV_FORMAT = "base"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://ext/libav/gstav.h;beginline=1;endline=18;md5=a752c35267d8276fd9ca3db6994fca9c"

DEPENDS += "xz"
PV = "1.10.0+git${SRCPV}"
