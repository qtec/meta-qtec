SUMMARY = "Terminals served to term.js using Tornado websockets"
DESCRIPTION = "This is a Tornado websocket backend for the term.js Javascript terminal emulator library"
SECTION = "devel/python"
LICENSE = "UNKNOWN"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0d984aaee5e8437ee0d76c55bbdb058b"

SRC_URI = "https://pypi.python.org/packages/58/59/aabe84fce2f45da10165435cec204d982863e176f6849a4a4fe2652a20a8/terminado-0.6.tar.gz"

SRC_URI[md5sum] = "5b6c65da27fe1ed07a9f80f0588cdaba"
SRC_URI[sha256sum] = "2c0ba1f624067dccaaead7d2247cfe029806355cef124dc2ccb53c83229f0126"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/terminado/"
UPSTREAM_CHECK_REGEX = "/terminado/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/terminado-${PV}"

inherit setuptools3
