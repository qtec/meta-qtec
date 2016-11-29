SRC_URI = "git://github.com/qtec/gst-plugins-bad.git;branch=qtec;name=base"
SRC_URI += "git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common"
SRCREV_base = "cb6e3ff6d2747b726d6a6140e7546f20ece18b53"
SRCREV_common = "d01567411258358ddc6f632bf0ed2363a36ca795"
SRCREV_FORMAT = "base"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "openssl gtk+3 gdk-pixbuf atk libssh2"
FILES_${PN}-dev += "/usr/lib/gstreamer-1.0/include"
FILES_${PN} += "/usr/share/gstreamer-1.0"

PACKAGECONFIG += "opencv gtk opengl faac"
PV = "1.10.0+git${SRCPV}"
