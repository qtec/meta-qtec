SUMMARY = "Jupyter core package. A base package on which Jupyter projects rely."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=3956703c5c1fefa0fc1876fc9b4c7499"

SRC_URI = "https://pypi.python.org/packages/56/41/6b29a0646af48ee7545b0b488b1b00aa3b01f6b4a8f19e3339640982a694/jupyter_core-4.2.0.tar.gz"
SRC_URI += "file://use_python3.patch"

SRC_URI[md5sum] = "3068bbc2b8275d08bf84787d4f0a3bd5"
SRC_URI[sha256sum] = "44ec837a53bebf4e937112d3f9ccf31fee4f8db3e406dd0dd4f0378a354bed9c"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/jupyter_core/"
UPSTREAM_CHECK_REGEX = "/jupyter_core/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/jupyter_core-${PV}"

inherit setuptools3
