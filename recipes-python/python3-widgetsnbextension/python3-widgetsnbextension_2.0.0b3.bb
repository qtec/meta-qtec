SUMMARY = "IPython HTML widgets for Jupyter"
DESCRIPTION = "Interactive HTML widgets for Jupyter notebooks."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=6a5f59ecbb4533972aa18f3de07cdbba"

SRC_URI = "https://pypi.python.org/packages/d2/44/e29b4df0dbd9e3423d42055fa0efbd0e8294b4247a03ec266d0c0e575526/widgetsnbextension-2.0.0b3.tar.gz"

SRC_URI[md5sum] = "9fe7902e2bf350b3d7b07fa522a0053e"
SRC_URI[sha256sum] = "894a8a826a857471f52158aaed1e196465e15607cc4229de7eafd7957e233480"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/widgetsnbextension/"
UPSTREAM_CHECK_REGEX = "/widgetsnbextension/(?P<pver>(\d+[\.\-_]*)+)"

FILES_${PN} += "${datadir}"

S = "${WORKDIR}/widgetsnbextension-${PV}"

inherit setuptools3
