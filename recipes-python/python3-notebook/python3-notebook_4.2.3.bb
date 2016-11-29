SUMMARY = "A web-based notebook environment for interactive computing"
DESCRIPTION = "The Jupyter Notebook is a web application that allows you to create and share documents that contain live code, equations, visualizations, and explanatory text. The Notebook has support for multiple programming languages, sharing, and interactive widgets"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d235895c780fa844e875697e16e5787b"

SRC_URI = "https://pypi.python.org/packages/81/a1/20af1a3ea6090343b029d31f882c7e4c061133e0c25808835b1b59a187f8/notebook-4.2.3.tar.gz"
SRC_URI += "file://usepython3.patch"

SRC_URI[md5sum] = "c3501e6edaacd957ec651db016a4ce13"
SRC_URI[sha256sum] = "39a9603d3fe88b60de2903680c965cf643acf2c16fb2c6bac1d905e1042b5851"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/notebook/"
UPSTREAM_CHECK_REGEX = "/notebook/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/notebook-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-tornado python3-traitlets python3-jinja2 python3-markupsafe python3-pyzmq python3-nbformat python3-jsonschema python3-terminado python3-widgetsnbextension"
