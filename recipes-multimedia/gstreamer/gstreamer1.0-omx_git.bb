DEFAULT_PREFERENCE = "-1"

include recipes-multimedia/gstreamer/gstreamer1.0-omx.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c \
                    file://omx/gstomx.h;beginline=1;endline=21;md5=5c8e1fca32704488e76d2ba9ddfa935f"

SRC_URI = " \
    git://anongit.freedesktop.org/gstreamer/gst-omx;branch=master;name=gst-omx \
    git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;branch=master;name=common \
    file://usemesa.patch \
"

SRCREV_gst-omx = "0ddfc0554b84e195bf5400cf01df728be7299165"
SRCREV_common = "ac2f647695e7bd4b433ea108ee1d0e23901797d4"

SRCREV_FORMAT = "gst-omx"

S = "${WORKDIR}/git"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

PV = "1.10.0+git${SRCPV}"
