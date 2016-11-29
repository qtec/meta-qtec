SUMMARY = "Python Imaging Library (Fork)"
DESCRIPTION = "Pillow is the friendly PIL fork by Alex Clark and Contributors. PIL is the Python Imaging Library by Fredrik Lundh and Contributors"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=511fa97b9f2063fcbb87b52973174032"

SRC_URI = "https://pypi.python.org/packages/46/4f/94f6165052774839b4a4af0c72071aa528d5dc8cb8bc6bb43e24a55c10cc/Pillow-3.4.2.tar.gz"
SRC_URI += "file://nolocal.patch"

DEPENDS = "freetype jpeg tiff libwebp"

SRC_URI[md5sum] = "09ebb92ec5cbba13ff1acf139caf6b66"
SRC_URI[sha256sum] = "0ee9975c05602e755ff5000232e0335ba30d507f6261922a658ee11b1cec36d1"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/pillow/"
UPSTREAM_CHECK_REGEX = "/pillow/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/Pillow-${PV}"

inherit setuptools3
