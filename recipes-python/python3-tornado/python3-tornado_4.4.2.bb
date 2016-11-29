SUMMARY = "Tornado is a Python web framework and asynchronous networking library, originally developed at FriendFeed"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0d866c8344c97b84b4c7f4f3e19b65b3"

SRC_URI = "https://pypi.python.org/packages/1e/7c/ea047f7bbd1ff22a7f69fe55e7561040e3e54d6f31da6267ef9748321f98/tornado-4.4.2.tar.gz"

SRC_URI[md5sum] = "b4816ea209118667ffc52ce9ff06ac85"
SRC_URI[sha256sum] = "2898f992f898cd41eeb8d53b6df75495f2f423b6672890aadaf196ea1448edcc"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/tornado/"
UPSTREAM_CHECK_REGEX = "/tornado/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/tornado-${PV}"

inherit setuptools3
