SUMMARY = "Implements a XML/HTML/XHTML Markup safe string for Python"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6d1adcf45d69359f256c1cea3254127"

SRC_URI = "https://pypi.python.org/packages/c0/41/bae1254e0396c0cc8cf1751cb7d9afc90a602353695af5952530482c963f/MarkupSafe-0.23.tar.gz"

SRC_URI[md5sum] = "f5ab3deee4c37cd6a922fb81e730da6e"
SRC_URI[sha256sum] = "a4ec1aff59b95a14b45eb2e23761a0179e98319da5a7eb76b56ea8cdc7b871c3"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/markupsafe/"
UPSTREAM_CHECK_REGEX = "/markupsafe/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/MarkupSafe-${PV}"

inherit setuptools3
