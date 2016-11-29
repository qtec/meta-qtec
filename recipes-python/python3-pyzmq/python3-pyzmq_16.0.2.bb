SUMMARY = "Python bindings for 0MQ"
DESCRIPTION = "PyZMQ is the official Python binding for the ZeroMQ Messaging Library (http://www.zeromq.org). See the docs for more info."
SECTION = "devel/python"
LICENSE = "LGPLv3  & BSD"
LIC_FILES_CHKSUM = "file://COPYING.BSD;md5=11c65680f637c3df7f58bbc8d133e96e"
LIC_FILES_CHKSUM += "file://COPYING.LESSER;md5=12c592fa0bcfff3fb0977b066e9cb69e"

DEPENDS += "zeromq"

SRC_URI = "https://pypi.python.org/packages/af/37/8e0bf3800823bc247c36715a52e924e8f8fd5d1432f04b44b8cd7a5d7e55/pyzmq-16.0.2.tar.gz"
SRC_URI += "file://nolocaldir.patch"

SRC_URI[md5sum] = "9a8768b00a566a400d70318f8c359cfe"
SRC_URI[sha256sum] = "0322543fff5ab6f87d11a8a099c4c07dd8a1719040084b6ce9162bcdf5c45c9d"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/pyzmq/"
UPSTREAM_CHECK_REGEX = "/pyzmq/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/pyzmq-${PV}"

inherit setuptools3
