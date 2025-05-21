#!/usr/bin/env python3
import os
import sys

def replace_in_file(path, old, new):
    try:
        text = open(path, 'r', encoding='utf-8').read()
    except (UnicodeDecodeError, PermissionError, FileNotFoundError):
        return  # skip binaries, unreadable files, etc.
    if old not in text:
        return
    new_text = text.replace(old, new)
    with open(path, 'w', encoding='utf-8') as f:
        f.write(new_text)
    print(f'Updated: {path}')

def main():
    if len(sys.argv) != 3:
        print("Usage: replace.py <old_string> <new_string>")
        sys.exit(1)
    old, new = sys.argv[1], sys.argv[2]
    for root, dirs, files in os.walk('.'):
        for name in files:
            if not name.endswith(('.py')):
                continue
            replace_in_file(os.path.join(root, name), old, new)

if __name__ == '__main__':
    main()
