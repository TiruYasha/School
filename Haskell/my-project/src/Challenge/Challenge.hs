module Challenge where

    data Node = Node{
        name :: String,
        nodeLevel :: Int,
        nodes :: [Node]
    } deriving(Eq, Show)

    type Dungeon = [Node]

    type StartNode = Node
    type EndNode = Node

    data Settings = Settings{
        maxDepth :: Int,
        maxStartNodes :: Int
    }

    mockSettings = Settings {
        maxDepth = 10,
        maxStartNodes = 4
    }

    generateDungeon :: Settings -> Dungeon
    generateDungeon _ = []
    generateDungeon settings = generateBranches (maxStartNodes settings) (maxDepth settings)

    generateBranches :: Int -> Int -> Dungeon
    generateBranches 0 0 = []
    generateBranches 0 _ = []
    generateBranches _ 0 = []
    generateBranches maxStartNodes depth =  generateBranches (maxStartNodes + (-1)) depth ++ generateLevels depth

    generateLevels :: Int -> [Node]
    generateLevels 0 = []
    generateLevels depth =  [Node{ name = "A", nodeLevel = depth, nodes = generateLevels (depth + (-1))}]



    printDungeon dungeon = do{
        putStrLn "dungeon";
    }