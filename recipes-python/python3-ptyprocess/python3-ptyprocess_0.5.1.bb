SUMMARY = "Run a subprocess in a pseudo terminal"
DESCRIPTION = "Launch a subprocess in a pseudo terminal (pty), and interact with both the process and its pty."
SECTION = "devel/python"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cfdcd51fa7d5808da4e74346ee394490"

SRC_URI = "https://pypi.python.org/packages/db/d7/b465161910f3d1cef593c5e002bff67e0384898f597f1a7fdc8db4c02bf6/ptyprocess-0.5.1.tar.gz"

SRC_URI[md5sum] = "94e537122914cc9ec9c1eadcd36e73a1"
SRC_URI[sha256sum] = "0530ce63a9295bfae7bd06edc02b6aa935619f486f0f1dc0972f516265ee81a6"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/ptyprocess/"
UPSTREAM_CHECK_REGEX = "/ptyprocess/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/ptyprocess-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-resource"
