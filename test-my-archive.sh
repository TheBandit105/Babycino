#!/bin/bash

# Use this script to check your archive compiles correctly.
# Example: ./test-my-archive.sh my-babycino.tar.gz

# set -e makes the script exit automatically if any line fails.
set -e

echo "Starting script."
ARCHIVE=$(readlink -f $1)
TMPDIR=$(mktemp -d)
echo "Moving into $TMPDIR. Delete it yourself afterwards if you want."
cd $TMPDIR
echo "Extracting archive $ARCHIVE into $TMPDIR."
tar xzf $ARCHIVE
echo "Moving into $TMPDIR/babycino."
cd babycino
echo "Executing test script."
./test.sh
