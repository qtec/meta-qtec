SUMMARY = "Python package for creating and manipulating graphs and networks"
DESCRIPTION = "NetworkX is a Python package for the creation, manipulation, and study of the structure, dynamics, and functions of complex networks"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=925586ea588eb990de840dc71ea3752f"

SRC_URI = "https://pypi.python.org/packages/c2/93/dbb41b03cf7c878a7409c8e92226531f840a423c9309ea534873a83c9192/networkx-1.11.tar.gz"

SRC_URI[md5sum] = "6ef584a879e9163013e9a762e1cf7cd1"
SRC_URI[sha256sum] = "0d0e70e10dfb47601cbb3425a00e03e2a2e97477be6f80638fef91d54dd1e4b8"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/networkx/"
UPSTREAM_CHECK_REGEX = "/networkx/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/networkx-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-2to3"
