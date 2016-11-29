DESCRIPTION = "GStreamer Debug Viewer - View and analyze GStreamer debug log fil"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://gst-debug-viewer;md5=2a487d65b8ae703f262a34823d1ca46a;startline=6;endline=19"
DEPENDS = "intltool-native"
RDEPENDS_${PN} += "python-pygobject python-pycairo"

inherit distutils

SRCREV = "8c20943a9dffedaa2c2e477f54f5815c1de73f0e"
SRC_URI = "git://github.com/GStreamer/gst-devtools.git"
SRC_URI += "file://datadir.patch"
S = "${WORKDIR}/git/debug-viewer"

FILES_${PN} += "${datadir}/icons"
