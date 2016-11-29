SUMMARY = "Productive Interactive Computing"
DESCRIPTION = "IPython provides a rich toolkit to help you make the most out of using Python interactively."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.rst;md5=93ef43efbd25773bbce636bbad9d247f"

SRC_URI = "https://pypi.python.org/packages/89/63/a9292f7cd9d0090a0f995e1167f3f17d5889dcbc9a175261719c513b9848/ipython-5.1.0.tar.gz"

SRC_URI[md5sum] = "47c8122420f65b58784cb4b9b4af35e3"
SRC_URI[sha256sum] = "7ef4694e1345913182126b219aaa4a0047e191af414256da6772cf249571b961"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/ipython/"
UPSTREAM_CHECK_REGEX = "/ipython/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/ipython-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-shell python3-logging python3-compression python3-traitlets python3-pprint python3-pydoc python3-pkgutil python3-subprocess python3-threading python3-netclient python3-debugger python3-pygments python3-pexpect python3-unixadmin python3-pickleshare python3-prompt-toolkit python3-simplegeneric python3-sqlite3 python3-requests"
