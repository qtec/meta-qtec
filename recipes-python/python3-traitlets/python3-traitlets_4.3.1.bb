SUMMARY = "Traitlets Python config system"
DESCRIPTION = "A configuration system for Python applications"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=eec4de4d599518742e54e75954e33b46"

SRC_URI = "https://pypi.python.org/packages/b1/d6/5b5aa6d5c474691909b91493da1e8972e309c9f01ecfe4aeafd272eb3234/traitlets-4.3.1.tar.gz"

SRC_URI[md5sum] = "dd0b1b6e5d31ce446d55a4b5e5083c98"
SRC_URI[sha256sum] = "ba8c94323ccbe8fd792e45d8efe8c95d3e0744cc8c085295b607552ab573724c"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/traitlets/"
UPSTREAM_CHECK_REGEX = "/traitlets/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/traitlets-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-importlib python3-ipython-genutils python3-json python3-decorator python3-six"
