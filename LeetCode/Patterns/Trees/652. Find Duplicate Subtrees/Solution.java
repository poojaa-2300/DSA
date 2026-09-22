class Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    public String serialize(TreeNode root) {

        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        String key = root.val + "," + left + "," + right;

        map.put(key, map.getOrDefault(key, 0) + 1);

        if (map.get(key) == 2) {
            result.add(root);
        }

        return key;
    }
}