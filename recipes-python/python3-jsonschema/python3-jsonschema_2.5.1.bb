SUMMARY = "An implementation of JSON Schema validation for Python"
DESCRIPTION = "jsonschema is an implementation of JSON Schema for Python (supporting 2.6+ including Python 3)."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7a60a81c146ec25599a3e1dabb8610a8"

SRC_URI = "https://pypi.python.org/packages/f1/85/974bd633b8fc23b0ad4169dfff7f6ebd503ca1b1d8ec5ef6bae3cd78dbe2/jsonschema-2.5.1.zip"

SRC_URI[md5sum] = "e491298485bdefeecb0f1ca3d65e5292"
SRC_URI[sha256sum] = "9088494da4c74497a7a27842ae4ca9c3355b5f7754121edc440463eaf020f079"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/jsonshema/"
UPSTREAM_CHECK_REGEX = "/jsonschema/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/jsonschema-${PV}"

inherit setuptools3
