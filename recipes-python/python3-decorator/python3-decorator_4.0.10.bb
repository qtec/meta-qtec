SUMMARY = "Better living through Python with decorators"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=41e24e0e235a97e60cdb5c4137fa2cd0"

SRC_URI = "https://pypi.python.org/packages/13/8a/4eed41e338e8dcc13ca41c94b142d4d20c0de684ee5065523fee406ce76f/decorator-4.0.10.tar.gz"

SRC_URI[md5sum] = "434b57fdc3230c500716c5aff8896100"
SRC_URI[sha256sum] = "9c6e98edcb33499881b86ede07d9968c81ab7c769e28e9af24075f0a5379f070"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/decorator/"
UPSTREAM_CHECK_REGEX = "/decorator/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/decorator-${PV}"

inherit setuptools3
