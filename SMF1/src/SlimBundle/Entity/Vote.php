<?php

namespace SlimBundle\Entity;

/**
 * Vote
 */
class Vote
{
    /**
     * @var integer
     */
    private $note;

    /**
     * @var string
     */
    private $nomproduit;
    /**
     * @var string
     */
    private $commentaire;

    /**
     * @var integer
     */
    private $idvote;

    /**
     * @var integer
     */
    private $idutilisateur;


    /**
     * Set note
     *
     * @param integer $note
     *
     * @return Vote
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return integer
     */
    public function getNote()
    {
        return $this->note;
    }


    /**
     * Get idvote
     *
     * @return integer
     */
    public function getIdvote()
    {
        return $this->idvote;
    }

    /**
     * Set idutilisateur
     *
     * @param  $idutilisateur
     *
     * @return Vote
     */
    public function setIdutilisateur( $idutilisateur)
    {
        $this->idutilisateur = $idutilisateur;

        return $this;
    }

    /**
     * @return integer
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }

    /**
     * @return string
     */
    public function getNomproduit()
    {
        return $this->nomproduit;
    }

    /**
     * @param string $nomproduit
     */
    public function setNomproduit($nomproduit)
    {
        $this->nomproduit = $nomproduit;
    }

    /**
     * @return string
     */
    public function getCommentaire()
    {
        return $this->commentaire;
    }

    /**
     * @param string $commentaire
     */
    public function setCommentaire($commentaire)
    {
        $this->commentaire = $commentaire;
    }
}

