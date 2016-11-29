SUMMARY = "The Jupyter Notebook format"
DESCRIPTION = "This package contains the base implementation of the Jupyter Notebook format, and Python APIs for working with notebooks"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README.md;md5=289a45e80863a24a10912ee98772859a"

SRC_URI = "https://pypi.python.org/packages/c5/b5/f38ceeeac63e9b4d7d630151be8875beb3d4a86eba5b5ad9d3dbefadadea/nbformat-4.1.0.tar.gz"

SRC_URI[md5sum] = "9d71dd1aa7ce3cc04b191cce151d6645"
SRC_URI[sha256sum] = "dbf6c0ed0cb7c5a7184536368f1dd1ada2d48fd6f016e0f9e9b69236e28c0857"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/nbformat/"
UPSTREAM_CHECK_REGEX = "/nbformat/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/nbformat-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-traitlets python3-xml"
