DEFAULTTUNE ?= "bobcat-64"

require conf/machine/include/x86/arch-x86.inc

#Bobcat ABI
TUNEVALID[bobcat] = "Bobcat"
TUNE_CCARGS += "${@bb.utils.contains("TUNE_FEATURES", "bobcat", "-march=btver1 -mtune=btver1", "", d)}"


AVAILTUNES += "bobcat-64"
TUNE_FEATURES_tune-bobcat-64 = "bobcat m64"
BASE_LIB_tune-bobcat-64 = "lib64"
TUNE_PKGARCH_tune-bobcat-64 = "bobcat_64"
PACKAGE_EXTRA_ARCHS_tune-bobcat-64 = "${TUNE_PKGARCH_tune-bobcat-64}"
QEMU_EXTRAOPTIONS_bobcat_64 = "-cpu Opteron_G4,check=false"
