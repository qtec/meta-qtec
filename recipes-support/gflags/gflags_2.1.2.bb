DESCRIPTION = "The gflags package contains a C++ library that implements commandline flags processing. It includes built-in support for standard types such as string and the ability to define flags in the source file in which they are used"

HOMEPAGE = "https://github.com/gflags/gflags"

RDEPENDS_${PN} += "bash"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=c80d1a3b623f72bb85a4c75b556551df"

SRC_URI = "git://github.com/gflags/gflags.git;;nobranch=1"
SRCREV = "1a02f2851ee3d48d32d2c8f4d8f390a0bc25565c"
S = "${WORKDIR}/git/"

FILES_${PN}-dev += "${libdir}/cmake"

inherit cmake

EXTRA_OECMAKE="-DBUILD_SHARED_LIBS=ON"
