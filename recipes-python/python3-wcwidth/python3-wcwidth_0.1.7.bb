SUMMARY = "Measures number of Terminal column cells of wide-character codes"
DESCRIPTION = "This Library is mainly for those implementing a Terminal Emulator, or programs that carefully produce output to be interpreted by one"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11fba47286258744a6bc6e43530c32a1"

SRC_URI = "https://pypi.python.org/packages/55/11/e4a2bb08bb450fdbd42cc709dd40de4ed2c472cf0ccb9e64af22279c5495/wcwidth-0.1.7.tar.gz"

SRC_URI[md5sum] = "b3b6a0a08f0c8a34d1de8cf44150a4ad"
SRC_URI[sha256sum] = "3df37372226d6e63e1b1e1eda15c594bca98a22d33a23832a90998faa96bc65e"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/wcwidth/"
UPSTREAM_CHECK_REGEX = "/wcwidth/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/wcwidth-${PV}"

inherit setuptools3
