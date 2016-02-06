all:
	@cat Makefile

deps-tree:
	lein deps :tree

# Build an x86 version and run in a simulator
runsim:
	lein fruit doall

dt: deps-tree
rs: runsim
