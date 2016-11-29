SUMMARY = "Jupyter protocol implementation and client libraries"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d235895c780fa844e875697e16e5787b"

SRC_URI = "https://pypi.python.org/packages/88/03/d8e218721af0b084d4fda5e3bb89dc201505780f96ae060bf5e3e67c7707/jupyter_client-4.4.0.tar.gz"

SRC_URI[md5sum] = "8a428a07cbcd4f2e4ca7c2f728b718ea"
SRC_URI[sha256sum] = "c99a52fac2e5b7a3b714e9252ebf72cbf97536d556ae2b5082baccc3e5cd52ee"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/jupyter_client/"
UPSTREAM_CHECK_REGEX = "/jupyter_client/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/jupyter_client-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-traitlets python3-jupyter-core python3-ipywidgets"
