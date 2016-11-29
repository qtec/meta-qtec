PACKAGECONFIG += "check"

DEPENDS += "libcap libunwind"

SRC_URI = " \
	git://anongit.freedesktop.org/gstreamer/gstreamer;name=base;branch=1.10 \
	git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
	"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV_base = "81ee25ad4e8db836528a8be1ac85655506fd8eb4"
SRCREV_common = "f980fd91c1c1fd01333966041a4a535366e897bd"
SRCREV_FORMAT = "base"

FILES_${PN}-dev += "/usr/lib/gstreamer-1.0/include"
FILES_${PN}-dbg += "/usr/share/bash-completion/helpers/.debug"
FILES_${PN} += "/usr/share/bash-completion/"

PV = "1.10.0+git${SRCPV}"
