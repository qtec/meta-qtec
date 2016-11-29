SUMMARY = "SciPy: Scientific Library for Python"
DESCRIPTION = "A configuration system for Python applications"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ec07996c0c2357f7bea29ff603edc501"

DEPENDS += "lapack libgfortran python3-numpy-native python3-numpy"

SRC_URI = "https://pypi.python.org/packages/22/41/b1538a75309ae4913cdbbdc8d1cc54cae6d37981d2759532c1aa37a41121/scipy-0.18.1.tar.gz"
SRC_URI += "file://gfortran"
SRC_URI += "file://fixpath.patch"

SRC_URI[md5sum] = "5fb5fb7ccb113ab3a039702b6c2f3327"
SRC_URI[sha256sum] = "8ab6e9c808bf2fb3e8576cd8cf07226d9cdc18b012c06d9708429a821ac6634e"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/scipy/"
UPSTREAM_CHECK_REGEX = "/scipy/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/scipy-${PV}"

do_compile_prepend() {
	#http://thread.gmane.org/gmane.comp.python.scientific.user/10391
   	unset LDFLAGS
	unset CFLAGS

	#hack for detecting fortran compiler
	chmod a+x ${WORKDIR}/gfortran
	export PATH="${WORKDIR}:${PATH}"
}

inherit setuptools3

RDEPENDS_${PN} += "python3-numpy"

BLAS = "${STAGING_LIBDIR}/libblas.so"
LAPACK = "${STAGING_LIBDIR}/liblapack.so"
export BLAS
export LAPACK
