DESCRIPTION = "Gstreamer introspection gtk debugger and explorer tool"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"
RDEPENDS_${PN} += "python-setuptools python-pygobject python-gst-1.0 gstreamer1.0-plugins-base"

SRC_URI = "git://github.com/UbiCastTeam/gst-gtklaunch-1.0.git"
SRCREV = "f53b1eb2a5ee089eef641d885103308411712f0e"

S = "${WORKDIR}/git"

inherit distutils
