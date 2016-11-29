SUMMARY = "IPython Kernel for Jupyter"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=86d7909bba8bb8a03637ab8020bf6071"

SRC_URI = "https://pypi.python.org/packages/23/7a/a82c599760efe61862154120fece1d877a18657cf9d9b5baf75da4931c8f/ipykernel-4.5.1.tar.gz"

SRC_URI[md5sum] = "08cb3910312d5304d6a9f38957d14b4d"
SRC_URI[sha256sum] = "520c855c6652651c6796a3dd8bc89d533023ac65c5ccf812908187d6f0e461da"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/ipykernel/"
UPSTREAM_CHECK_REGEX = "/ipykernel/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/ipykernel-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-traitlets python3-tornado python3-jupyter-client python3-ipython"
