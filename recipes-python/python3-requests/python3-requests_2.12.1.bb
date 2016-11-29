SUMMARY = "Python HTTP for Humans."
DESCRIPTION = "Requests is the only Non-GMO HTTP library for Python, safe for human consumption."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9bb3515869c0f426cb8441c899ae7f5"

SRC_URI = "https://pypi.python.org/packages/6e/40/7434b2d9fe24107ada25ec90a1fc646e97f346130a2c51aa6a2b1aba28de/requests-2.12.1.tar.gz"

SRC_URI[md5sum] = "8c8ff05ea401ea22718038c3a416ea50"
SRC_URI[sha256sum] = "2109ecea94df90980be040490ff1d879971b024861539abb00054062388b612e"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/requests/"
UPSTREAM_CHECK_REGEX = "/requests/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/requests-${PV}"

inherit setuptools3
