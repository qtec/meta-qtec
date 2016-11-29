SUMMARY = "Interactive HTML Widgets"
DESCRIPTION = "Interactive HTML widgets for Jupyter notebooks and the IPython kernel"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=f23c68e967d00a371b53dea4c0e9ec12"

SRC_URI = "https://pypi.python.org/packages/87/54/392d32c5544493a2a3ca0bcf00509b8db72955a5a1a663bc01719adb63b8/ipywidgets-6.0.0.beta3.tar.gz"

SRC_URI[md5sum] = "510913b70bd21b70b52460e32110315c"
SRC_URI[sha256sum] = "03c9d8d1f42a415e77f6e171e7f96dd2840adaa815a154cc71bc9e0032d21151"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/ipywidgets/"
UPSTREAM_CHECK_REGEX = "/ipywidgets/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/ipywidgets-${PV}"

inherit setuptools3
