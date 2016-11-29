SUMMARY = "Image processing routines for SciPy"
DESCRIPTION = "Image processing algorithms for SciPy, including IO, morphology, filtering, warping, color manipulation, object detection, etc."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8e3ca74d79f64ff70c1878021251d785"

DEPENDS += "python3-numpy python3-numpy-native"

SRC_URI = "https://pypi.python.org/packages/86/d0/b0192dc9a544da90f2d9150bcd84b981c6873e42a1f752b6affb89180ad8/scikit-image-0.12.3.tar.gz"

SRC_URI[md5sum] = "04ea833383e0b6ad5f65da21292c25e1"
SRC_URI[sha256sum] = "82da192f0e524701e89c5379c79200bc6dc21373f48bf7778a864c583897d7c7"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/scikit-image/"
UPSTREAM_CHECK_REGEX = "/scikit-image/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/scikit-image-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-scipy python3-numpy python3-multiprocessing python3-pillow python3-networkx"
