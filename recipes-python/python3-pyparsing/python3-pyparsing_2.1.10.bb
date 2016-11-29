SUMMARY = "Python parsing module"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb46329938e6bc829b256e37d5c1e31a"

SRC_URI = "https://pypi.python.org/packages/38/bb/bf325351dd8ab6eb3c3b7c07c3978f38b2103e2ab48d59726916907cd6fb/pyparsing-2.1.10.tar.gz"

SRC_URI[md5sum] = "065908b92904e0d3634eb156f44cc80e"
SRC_URI[sha256sum] = "811c3e7b0031021137fc83e051795025fcb98674d07eb8fe922ba4de53d39188"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/pyparsing/"
UPSTREAM_CHECK_REGEX = "/pyparsing/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/pyparsing-${PV}"

inherit setuptools3
