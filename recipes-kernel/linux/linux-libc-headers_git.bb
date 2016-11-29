require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PE = "1"

PV = "4.8.0"
SRC_URI = "git://github.com/qtec/linux.git;branch=v4.8-qtec"
SRCREV = "d225f1336f79a4529d87daa528c660734f1cb8d3"
S = "${WORKDIR}/git"
