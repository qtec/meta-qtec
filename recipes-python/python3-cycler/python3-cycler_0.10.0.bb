SUMMARY = "Composable style cycles"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7713fe42cd766b15c710e19392bfa811"

SRC_URI = "https://pypi.python.org/packages/c2/4b/137dea450d6e1e3d474e1d873cd1d4f7d3beed7e0dc973b06e8e10d32488/cycler-0.10.0.tar.gz"

SRC_URI[md5sum] = "4cb42917ac5007d1cdff6cccfe2d016b"
SRC_URI[sha256sum] = "cd7b2d1018258d7247a71425e9f26463dfb444d411c39569972f4ce586b0c9d8"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/cycler/"
UPSTREAM_CHECK_REGEX = "/cycler/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/cycler-${PV}"

inherit setuptools3
