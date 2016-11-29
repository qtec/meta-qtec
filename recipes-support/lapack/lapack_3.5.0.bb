DESCRIPTION = "Linear Algebra PACKage"
HOMEPAGE = "http://www.netlib.org/lapack/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28d22455a300c40ef9b8d0a966edb580"
SRC_URI = "http://www.netlib.org/lapack/lapack-3.5.0.tgz \
 		file://set_soversion.patch"

SRC_URI[md5sum] = "b1d3e3e425b2e44a06760ff173104bdf"
SRC_URI[sha256sum] = "9ad8f0d3f3fb5521db49f2dd716463b8fb2b6bc9dc386a9956b8c6144f726352"

DEPENDS = "libgfortran"

inherit cmake

S="${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE="-DBUILD_SHARED_LIBS=ON"

FILES_${PN}-dev = "${libdir}/cmake ${libdir}/pkgconfig ${libdir}/libblas.so ${libdir}/liblapack.so"
FILES_${PN} += "${libdir}/libtmglib.so"

ALLOW_EMPTY_${PN} = "1"
