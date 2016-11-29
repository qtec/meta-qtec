SUMMARY = "Simple generic functions (similar to Python's own len(), pickle.dump(), etc.)"
SECTION = "devel/python"
LICENSE = "ZPL2.1"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=2ee72c527f0c22ea0bf9a8812053efd0"

SRC_URI = "https://pypi.python.org/packages/3d/57/4d9c9e3ae9a255cd4e1106bb57e24056d3d0709fc01b2e3e345898e49d5b/simplegeneric-0.8.1.zip"

SRC_URI[md5sum] = "f9c1fab00fd981be588fc32759f474e3"
SRC_URI[sha256sum] = "dc972e06094b9af5b855b3df4a646395e43d1c9d0d39ed345b7393560d0b9173"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/simplegeneric/"
UPSTREAM_CHECK_REGEX = "/simplegeneric/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/simplegeneric-${PV}"

inherit setuptools3
